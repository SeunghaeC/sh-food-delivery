<template>

    <v-card outlined>
        <v-card-title>
            OrderList # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="CustomerId" v-model="item.customerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="MenuInfo" v-model="item.menuInfo" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'OrderListViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/orderLists/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

