<template>
  <h1 style="position: absolute;top: 5%;left: 35%;">Update User</h1>
  <form>
    <div class="form-group row" style="position: absolute;top: 20%;left: 35%;">
      <label for="name" class="col-sm-2 col-form-label">name</label>
      <div class="col-sm-10">
        <input type="text" required class="form-control" id="name" v-model="name">
      </div>
    </div>
    <div class="form-group row" style="position: absolute;top: 40%;left: 35%;">
      <label for="age" class="col-sm-2 col-form-label">Age</label>
      <div class="col-sm-10">
        <input type="number" min="1" class="form-control" id="age" v-model="age">
      </div>
    </div>
    <div class="form-group row" style="position: absolute;top: 60%;left: 40%;">
      <div class="col-sm-10">
        <button type="button" class="btn btn-primary" @click="updateData">update</button>
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
    getData(index) {
      let url = "http://localhost:8081/api/v1/user/" + index;
      this.axios.get(url, {
        headers: {
          'Content-Type': 'application/json',
        }
      }).then(
        (result) => {
          console.log(result);
          this.name = result.data.name;
          this.age = result.data.age;
        });
    },
    updateData() {
      if (this.name != "") {
        let url = "http://localhost:8081/api/v1/user/" + this.$route.params.id;
        this.axios.request({
          url: url,
          data: {
            name: this.name,
            age: this.age
          }, method: 'put'
        }).then(
          (response) => {
            console.log(response.status);
            this.$router.push({ name :"home"})
          }).catch(e => {
            alert("錯誤");
            console.log(e);
          });

      } else {
        alert("name 不為空值")
      }
    }
  },
  created() {
    this.getData(this.$route.params.id)
  }
}
</script>