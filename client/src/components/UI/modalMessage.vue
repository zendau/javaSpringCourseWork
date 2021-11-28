<template>
  <div v-if="status">
    <div class="overlay"></div>
    <div class="modal" tabindex="-1">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Сообщение</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" @click="closeModal"></button>
          </div>
          <div class="modal-body">
            <p>{{ modalMessage }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "modalMessage",
  props: {
    messageCode: {
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
    modalMessage: function () {

      switch (this.messageCode) {

        case 12:
          return "Выберите курьера для данной операции"
        case 24:
          return "Предметов для продажи нет в наличии"
        case 25:
          return "Не верный логин или пароль"
        case 50:
          return "Не выбрано изображение при отправке"
        case 56:
          return "Ошибка при добавлении товара. Пожалуйста перезагрузите страницу и попробуйте снова."
        case 57:
          return "Товар успешно добавлен."
        case 58:
          return "Товар успешно зарегестрирован."
        case 59:
          return "Ошибка при регистрации товара. Пожалуйста перезагрузите страницу и попробуйте снова."
        case 1062:
          return "Указанное имя для данного значения уже используется"
        default:
          return "Неизвестное сообщегие"
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

.modal {
  display: block;
  top: 80px;
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