import { createStore } from 'vuex'
import $api from "../axios";

export default createStore({
  state: {
    authStatus: false
  },
  mutations: {
    changeStatus(state, status) {
      state.authStatus = status
    }
  },
  actions: {
    async updateStatus(ctx, data) {

      const res = await $api.post("/login", {
        login: data.login,
        password: data.password
      })

      if (res) {
        localStorage.setItem("auth", "true")
        ctx.commit("changeStatus", true)
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
