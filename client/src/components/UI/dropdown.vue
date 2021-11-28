<template>
  <li class="nav-item dropdown" @mouseleave="active = false">
    <router-link @click="active = !active" class="nav-link dropdown-toggle" :class="{show: active}" :to="$route.fullPath" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
      {{ title }}
    </router-link>
    <ul class="dropdown-menu" :class="{show: active}" aria-labelledby="navbarDropdown">
      <slot/>
    </ul>
  </li>
</template>

<script>
export default {
  name: "dropdownElement",
  props: {
    title: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      active: false
    }
  }
}
</script>

<style scoped>

</style>