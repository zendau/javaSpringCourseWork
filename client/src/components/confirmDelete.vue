<template>
  <div>
    <div class="overlay"></div>
    <div class="container">
      <h1>Подтверждение удаления</h1>
      <p>Вы действительно хотите удалить значение таблицы <b>{{type}}</b> с id - <b>{{id}}</b> </p>
      <div class="btn-container">
        <button @click="confirm">Удалить выбранное значение</button>
        <button @click="cancel">Отменить удаление</button>
      </div>
    </div>
  </div>
</template>

<script>
import $api from "../axios";

export default {
  name: "ConfirmDelete",
  data() {
    return {
      type: "",
      id: 0
    }
  },
  mounted() {
    this.type = this.$route.params.type
    this.id = this.$route.params.id
  },
  methods: {
    async confirm() {

      await $api.delete("/goods/delete", {
        data: {
          type: this.type,
          id:  this.id
        }
      })

      this.$router.back()

    },
    cancel() {
      this.$router.back()
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
  height: 350px;
  background-color: #EED6C4;
  width: 700px;
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
  width: 300px;
  height: 40px;
  font-size: 18px;
  cursor: pointer;
  margin: 50px 0 15px;
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

.btn-container {
  display: flex;
  width: 100%;
  justify-content: space-evenly;
}

</style>