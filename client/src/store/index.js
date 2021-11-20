import { createStore } from 'vuex'
import $api from "../axios";

export default createStore({
  state: {
    authStatus: false,
    errorCode: 0
  },
  mutations: {
    changeStatus(state, status) {
      state.authStatus = status
    },
    updateErrorCode(state, code) {
      state.errorCode = code
    }
  },
  actions: {
    async updateStatus(ctx, data) {

      const res = await $api.post("/login", {
        login: data.login,
        password: data.password
      })

      if (res.data) {
        localStorage.setItem("auth", "true")
        ctx.commit("changeStatus", true)
      } else {
        ctx.commit("updateErrorCode", 25)
      }
    },
    checkStatus(ctx) {

      const value = (localStorage.getItem("auth") === 'true')
      ctx.commit("changeStatus", value)

    }
  },
  getters: {
    getAuthStatus: state => {
      return state.authStatus
    }
  },
  modules: {
  }
})
