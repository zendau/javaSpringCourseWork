<template>
  <navbar-component/>
  <router-view/>
  <modal-message :message-code="messageCode" :status="messageStatus"  />
</template>

<script>
import modalMessage from "./components/UI/modalMessage";
import NavbarComponent from "./components/navbar";
export default {
  components: {NavbarComponent, modalMessage},
  data() {
    return {
      messageStatus: false,
      messageCode: 0,
      auth: false
    }
  },
  provide() {
    return {
      update: this.updateMessage
    }
  },
  mounted() {
    this.$store.dispatch("checkStatus")
    this.auth = this.$store.state.auth
  },
  methods: {
    updateMessage(newStatus, code) {

      this.messageStatus = newStatus
      this.messageCode = code
    }
  }
}
</script>


<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}



.table {
  width: 1200px;
  margin: 20px auto;
}

.btn-mb {
  margin-bottom: 30px;
}

.form-container {
  margin-top: 30px;
}

</style>