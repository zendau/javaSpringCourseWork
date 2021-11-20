<template>
  <div>
    <div class="overlay"></div>
    <div class="modal" tabindex="-1">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Оформление покупки</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" @click="closeModal"></button>
          </div>
          <div class="modal-body">
            <form @submit.prevent="buyBasket">
              <div class="mb-3">
                <label for="email" class="form-label">Введите ваш email</label>
                <input type="email" class="form-control" id="email" required v-model="email" placeholder="user@gmail.com"/>
              </div>
              <p>Сумма к оплате - {{currency}}</p>
              <button type="submit" class="btn btn-primary">Произвести покупку</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import $api from "../axios";

export default {
  name: "BuyBasket",
  props: ["currency", "items"],
  methods: {
    closeModal() {
      this.$emit("closeModal")
    },
    async buyBasket() {

      const data = {
        items: [
          {
            id: 0,
            count: 0
          }
        ],
        mailOfBuyer: ""
      }


      this.items.forEach((item,index) => {
        data.items[index].id = item.itemData[0]
        data.items[index].count = item.count
      })


      data.mailOfBuyer = this.email


      console.log(data)

      await $api.post("/goods/buyBasket", {
        items: data,
        mailOfBuyer: this.email,
      })
      this.closeModal()
    }
  },
  data() {
    return {
      email: ""
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

.modal {
  display: block;
}

.mb-3 {
  display: grid;
  justify-items: baseline;
}
//.container {
//  position: fixed;
//  top: 40%;
//  left: 50%;
//  transform: translate(-50%, -40%);
//  z-index: 200;
//  height: 350px;
//  background-color: #EED6C4;
//  width: 600px;
//  box-shadow: 0px 0px 8px 0px rgba(34, 60, 80, 0.2);
//  display: flex;
//  flex-direction: column;
//  align-items: center;
//}
//h1 {
//  color: black;
//  z-index: 100;
//  font-size: 40px;
//  margin-top: 20px;
//  margin-bottom: 10px;
//}
//button {
//
//
//  border: none;
//  border-radius: 6px;
//  width: 200px;
//  height: 40px;
//  font-size: 18px;
//  cursor: pointer;
//  margin: 50px 0 15px;
//  background-color: #E26A2C;
//  color: #fff;
//  padding: 5px;
//  transition: .5s;
//  &:hover {
//    background-color: #C36A2D;
//  }
//}
//
//.item-container {
//  p, input {
//    font-size: 18px;
//  }
//
//  input {
//    padding: 5px;
//  }
//
//  width: 90%;
//
//  display: flex;
//  justify-content: space-between;
//  align-items: center;
//  margin-bottom: 10px;
//}

</style>