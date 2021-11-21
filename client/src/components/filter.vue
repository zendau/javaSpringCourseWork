<template>
  <input type="date" v-model="date">
<!--  <select class="form-select" @change="onChange" v-model="month">-->
<!--    <option selected disabled>Выберите месяц</option>-->
<!--    <option v-for="(month,index) in months" :key="month" :value="index">{{month}}</option>-->
<!--  </select>-->

<!--  <select class="form-select" @change="onChange" v-model="year">-->
<!--    <option selected disabled>Выберите год</option>-->
<!--    <option v-for="year in years" :key="year" :value="year">{{year}}</option>-->
<!--  </select>-->
</template>

<script>
export default {
  name: "SalesFilter",
  emits: ["updateFilter"],
  data() {
    return {
      months: [],
      years: [],
      month: "",
      year: "",
      date: ""
    }
  },
  mounted() {
    for (let i = 0; i < 12; i++) {
      const d = new Date((i + 1) + '/1');
      this.months.push(d.toLocaleDateString(undefined, {month: 'long'}));
    }

    const year = new Date().getFullYear()

    for (let i = year; i >= 1990; i--) {
      this.years.push(i)
    }
  },
  methods: {
    onChange() {
      this.$emit("updateFilter", this.date)
    }
  }
}
</script>

<style scoped>

</style>