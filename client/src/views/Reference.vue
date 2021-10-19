<template>
  <div>
    Справочные таблицы
    <RouterLink class="link" to="/workers">Работники</RouterLink>
    <RouterLink class="link" to="/sales">Продажи</RouterLink>
  </div>
</template>

<script>
  export default {
    data() {
      return {

      }
    },
    methods: {

    }
  }
</script>

<style scoped>
  .link {
    display: block;
    margin: 10px;
    font-size: 18px;
  }
</style>