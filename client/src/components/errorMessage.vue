<template>
  <div v-if="status">
    <div class="overlay" @click="closeModal"></div>
    <div class="container">
      <h1>{{errorMessage}}</h1>
      <button @click="closeModal" type="submit">Закрыть</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "errorMessage",
  props: {
    errorCode: {
      type: Number
    },
    status: {
      type: Boolean,
      default: true
    }
  },
  methods: {
    closeModal() {
      this.update(false)
    }
  },
  inject: ['update'],
  computed: {
    errorMessage: function () {

      switch (this.errorCode) {

        case 10:
          return "test2"
        case 1062:
          return "Указанное имя для данного значения уже используется"
        default:
          return "test"
      }


    }
  }
}
</script>

<style lang="scss" scoped>
.overlay {
  width: 100%;
  height: 100vh;
  position: fixed;
  top: 0;
  left: 0;
  background-color: gray;
  opacity: .3;
}
.container {
  position: fixed;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -40%);
  z-index: 200;
  height: 300px;
  background-color: #EED6C4;
  width: 600px;
  box-shadow: 0px 0px 8px 0px rgba(34, 60, 80, 0.2);
  display: flex;
  flex-direction: column;
  align-items: center;
}
h1 {
  color: black;
  z-index: 100;
  font-size: 40px;
}
button {


  border: none;
  border-radius: 6px;
  width: 200px;
  height: 40px;
  font-size: 18px;
  cursor: pointer;
  margin: 20px 0 15px;
  background-color: #E26A2C;
  color: #fff;
  padding: 5px;
  transition: .5s;
  &:hover {
    background-color: #C36A2D;
  }
}

.item-container {
  p, input {
    font-size: 18px;
  }

  input {
    padding: 5px;
  }

  width: 90%;

  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 10px;
}

</style>