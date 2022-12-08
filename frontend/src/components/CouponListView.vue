<template>

    <v-data-table
        :headers="headers"
        :items="couponList"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'CouponListView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "customerId", value: "customerId" },
                { text: "storedId", value: "storedId" },
                { text: "isUsed", value: "isUsed" },
                { text: "discountAmt", value: "discountAmt" },
            ],
            couponList : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/couponLists'))

            temp.data._embedded.couponLists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.couponList = temp.data._embedded.couponLists;
        },
        methods: {
        }
    }
</script>

