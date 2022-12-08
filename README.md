# sh-food-delivery

![image](https://user-images.githubusercontent.com/487999/79708354-29074a80-82fa-11ea-80df-0db3962fb453.png)


# 목차

- [음식 배달(2022.12.06)](#---)
  - [서비스 시나리오](#서비스-시나리오)
  - [체크포인트](#체크포인트)
  - [분석/설계](#분석/설계)
    - [이벤트 스토밍 결과](#Event-Storming-결과)
  - [구현](#구현)
    - [Saga (Pub / Sub)](#Saga-(Pub-/-Sub))
    - [CQRS](#CQRS)
    - [Compensation / Correlation](#Compensation-/-Correlation)
    - [Request / Response](#Request-/-Response)
    - [Circuit Breaker](#Circuit-Breaker)
    - [Gateway / Ingress](#Gateway-/-Ingress)
  - [수정 및 추가 사항](#수정-및-추가-사항)


# 서비스 시나리오

기능적 요구사항
1. 고객이 메뉴를 선택하여 주문한다
1. 고객이 결제한다
1. 주문이 되면 주문 내역이 입점상점주인에게 전달된다
1. 상점주인이 확인하여 요리해서 배달 출발한다
1. 고객이 주문을 취소할 수 있다
1. 주문이 취소되면 배달이 취소된다
1. 고객이 주문상태를 중간중간 조회한다
1. 주문상태가 바뀔 때 마다 카톡으로 알림을 보낸다

비기능적 요구사항
1. 트랜잭션
    1. 결제가 되지 않은 주문건은 아예 거래가 성립되지 않아야 한다  Sync 호출 
1. 장애격리
    1. 상점관리 기능이 수행되지 않더라도 주문은 365일 24시간 받을 수 있어야 한다  Async (event-driven), Eventual Consistency
    1. 결제시스템이 과중되면 사용자를 잠시동안 받지 않고 결제를 잠시후에 하도록 유도한다  Circuit breaker, fallback
1. 성능
    1. 고객이 자주 상점관리에서 확인할 수 있는 배달상태를 주문시스템(프론트엔드)에서 확인할 수 있어야 한다  CQRS
    1. 배달상태가 바뀔때마다 카톡 등으로 알림을 줄 수 있어야 한다  Event driven

# 체크포인트

1. Saga (Pub / Sub)
2. CQRS
3. Compensation / Correlation
4. Request / Response
5. Circuit Breaker
6. Gateway / Ingress


# 분석/설계
## Event Storming 결과
![이벤트스토밍](https://user-images.githubusercontent.com/119824334/205817582-9afbb207-d702-4b15-9c74-de7c0968480a.png)

# 구현
## Saga(Pub/Sub)

Order.java

@PostPersist
public void onPostPersist(){

    OrderPlaced orderPlaced = new OrderPlaced(this);
    orderPlaced.publishAfterCommit();

}

------------------------------------------------------------------------------------------

PolicyHandler.java

@StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
public void wheneverOrderPlaced_Pay(@Payload OrderPlaced orderPlaced){

    OrderPlaced event = orderPlaced;
    System.out.println("\n\n##### listener Pay : " + orderPlaced + "\n\n");

    // Sample Logic //
    Order.pay(event);
    Payment.pay(event);

}

## CQRS
이벤트스토밍 coupon :
![이벤트스토밍_쿠폰](https://user-images.githubusercontent.com/119824334/205818614-d719b90d-d660-40f3-9a5c-421f7f32ab78.png)
![이벤트스토밍_쿠폰_CQRS_1](https://user-images.githubusercontent.com/119824334/205818625-a46a5fe3-c502-478b-afa3-3253b8d2d5e6.png)


이벤트스토밍 notice :
![이벤트스토밍_알림](https://user-images.githubusercontent.com/119824334/205818649-9f13d6b1-15a7-4649-89ac-4c342d0657df.png)
![이벤트스토밍_알림_CQRS_1](https://user-images.githubusercontent.com/119824334/205818655-0ee7d55a-8dd9-4a85-9b58-65e517594d9b.png)
![이벤트스토밍_알림_CQRS_2](https://user-images.githubusercontent.com/119824334/205818663-0524609c-9ef4-4744-b3d8-2e27fa254f59.png)
![이벤트스토밍_알림_CQRS_3](https://user-images.githubusercontent.com/119824334/205818667-aeea465d-bd36-450c-9fe4-571208a305d2.png)

## Compensation / Correlation
단골쿠폰 발송 : 가게 주인이 단골고객에게 쿠폰을 발송하기 위한 '쿠폰 발송' 버튼을 클릭한다.
![Compensation](https://user-images.githubusercontent.com/119824334/205849219-08dff944-a690-48d1-94bd-ea389cbb40af.jpg)

## Request / Response
결제시 고객의 쿠폰정보를 가져오기 위한 요청
![이벤트스토밍_req_res](https://user-images.githubusercontent.com/119824334/205840942-8f3a11a1-1c63-42e1-9fcb-82a918b4d762.png)
![이벤트스토밍_req_res_2](https://user-images.githubusercontent.com/119824334/205845187-75085f9a-e743-4b92-9c62-deb7fc4155de.png)

## Circuit Breaker
결제시 고객의 쿠폰정보를 가져올 때 10초동안 응답이 지연되면 에러 발생
![서킷브레이커](https://user-images.githubusercontent.com/119824334/205847232-24f9704b-b1ab-4b5e-b5bd-1a4e9706ceaa.png)

## Gateway
![gateway](https://user-images.githubusercontent.com/119824334/205851983-0a77c1ba-ad93-4bc1-922e-644a0a240ddc.png)


# 수정 및 추가 사항

1. 가게 주인이 가게로 주문된 주문정보 및 단골고객 정보를 확인할 수 있다.
![추가사항1](https://user-images.githubusercontent.com/119824334/205852752-df859586-6382-4e56-ad34-5e6c0d30f22c.png)

2. 가게 주인이 단골고객에게 쿠폰을 발송할 수 있다.
![이벤트스토밍_추가사항2](https://user-images.githubusercontent.com/119824334/205840972-beed56a2-daae-416a-a3b1-9198e59f5a94.jpg)

