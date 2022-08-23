<template>
  <h1 style="position: absolute;top: 10%;left: 35%;">add User</h1>
  <form>
    <div class="form-group row" style="position: absolute;top: 25%;left: 29%;">
      <label for="inputName" class="col-sm-2 col-form-label">name</label>
      <div class="col-sm-10">
        <input v-model="name" required type="text" class="form-control" id="inputName">
      </div>
    </div>
    <br/>
    <div class="form-group row" style="position: absolute;top: 40%;left: 30%;">
      <label for="inputAge" class="col-sm-2 col-form-label">age</label>
      <div class="col-sm-10">
        <input type="number" min="1" class="form-control" id="inputAge" v-model="age">
      </div>
    </div>
    <br />
    <div class="form-group row" style="position: absolute;top: 60%;left: 40%;">
      <div class="col-sm-10">
        <button type="button" class="btn btn-primary" @click="addData()">add</button>
      </div>
    </div>
  </form>
</template>
<script>
export default {
  data() {
    return {
      name: "",
      age: 0
    }
  },
  methods: {
    addData() {
      if(this.name!=""){
        let url = "http://localhost:8081/api/v1/user";
        this.axios.request({
          url: url,
          data: {
            name: this.name,
            age: this.age
          }, method: 'post'
        }).then(
          (result) => {
            console.log(result);
            this.$router.push({ name: "home" })
          }).catch(e => {
            console.log(e);
            console.log(url);
            alert("錯誤")
          })
      }else{
        alert("name 不為空值")
      }
    }
  }
}
</script>
