<template>
  <el-menu class="el-menu-demo" mode="horizontal">
    <el-menu-item index="1" @click="handleGo('/notice')">sample</el-menu-item>
    <el-menu-item index="2" @click="handleGo('/codeList')"
      >code List</el-menu-item
    >
  </el-menu>
</template>

<script>
export default {
  data () {
    return {}
  },
  methods: {
    handleGo (title) {
      this.$router.push({ path: title })
    }
  }
}
</script>
