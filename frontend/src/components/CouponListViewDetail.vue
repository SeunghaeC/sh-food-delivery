<template>

    <v-card outlined>
        <v-card-title>
            CouponList # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="CustomerId" v-model="item.customerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="StoredId" v-model="item.storedId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="IsUsed" v-model="item.isUsed" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DiscountAmt" v-model="item.discountAmt" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'CouponListViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/couponLists/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

