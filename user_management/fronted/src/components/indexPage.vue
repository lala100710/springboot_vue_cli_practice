<template >
  <div class="container">
    <h1></h1>
    <div class="table-wrapper">
      <div class="table-title">
        <div class="row">
          <div class="add-button">
            <button type="button" class="btn btn-outline-success" onclick="window.location.href='/add'">add
              User</button>
          </div>
          <div class="col-sm-4">
            <div class="input-group" >
              <input type="search" v-model="name" class="form-control rounded" placeholder="Search" aria-label="Search"
                aria-describedby="search-addon" />
              <button type="button" @click="getDataByName()" class="btn btn-outline-primary">search</button>
            </div>
          </div>

        </div>
      </div>
      <br />
      <table class="table  table-hover table-bordered">
        <thead>
          <tr>
            <th>編號 <i class="fa fa-sort"></i></th>
            <th>名字</th>
            <th>年齡 <i class="fa fa-sort"></i></th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody id="tr" v-if="user.length > 1">
          <tr v-for="i in user" :key="i.id">
            <td>{{ i.id }}</td>
            <td>{{ i.name }}</td>
            <td>{{ i.age }}</td>
            <td>
              <a v-bind:href="'/update/' + i.id" class="edit" title="Edit" data-toggle="tooltip"><i
                  class="material-icons">&#xE254;</i></a>
              <a href="" class="delete" title="Delete" @click="deleteData(i.id)"><i
                  class=" material-icons">&#xE872;</i></a>
            </td>
          </tr>
        </tbody>
        <tbody id="tr" v-else>
          <tr>
            <td>{{ user.id }}</td>
            <td>{{ user.name }}</td>
            <td>{{ user.age }}</td>
            <td>
              <a v-bind:href="'/update/' + user.id" class="edit" title="Edit" data-toggle="tooltip"><i
                  class="material-icons">&#xE254;</i></a>
              <a href="" class="delete" title="Delete" @click="deleteData(user.id)"><i
                  class=" material-icons">&#xE872;</i></a>
            </td>
          </tr>
        </tbody>
      </table>

    </div>

  </div>
</template>
<script>
export default {
  name: 'indexPage',
  data() {
    return {
      user: [],
      name: ""

    };
  },
  props: {
    msg: String
  },
  created() {
    this.getData()
  },
 
  methods: {
   
    getDataByName() {
      let url = "http://localhost:8081/api/v1/user/?name=" + this.name;
      this.axios.get(url, {
        headers: {
          'Content-Type': 'application/json',
        }
      }).then(
        (result) => {
          console.log(result.data);
          if(result.data == ""){
            this.getData();
          }else{
              this.user = result.data;
          }
        

        }).catch(e=>{
          console.log(e);
        
        });
    },
    getData() {
      let url = "http://localhost:8081/api/v1/user";
      this.axios.get(url, {
        headers: {
          'Content-Type': 'application/json',
        }
      }).then(
        (result) => {
          console.log(result);
          this.user = result.data;

        });
    },
    deleteData(index) {
      if(window.confirm("確認刪除此 user 嗎")){
        let url = "http://localhost:8081/api/v1/user/" + index;
        this.axios.delete(url).then(
          (result) => {
            console.log(result);
            this.user = result.data;

          }).catch(e => {
            this.text = index
            console.log(e);
            // window.location.reload();
          });
      }
    
    }
  }
}
</script>
<style >
@media (min-width: 1025px) {
  .h-custom {
    height: 100vh !important;
  }
}

.add-button {
  position: absolute;
  top: 70px;
  left: 500px
}
.card-registration .select-input.form-control[readonly]:not([disabled]) {
  font-size: 1rem;
  line-height: 2.15;
  padding-left: .75em;
  padding-right: .75em;
}

.card-registration .select-arrow {
  top: 13px;
}

.gradient-custom-2 {
  /* fallback for old browsers */
  background: #a1c4fd;

  /* Chrome 10-25, Safari 5.1-6 */
  background: -webkit-linear-gradient(to right, rgba(161, 196, 253, 1), rgba(194, 233, 251, 1));

  /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  background: linear-gradient(to right, rgba(161, 196, 253, 1), rgba(194, 233, 251, 1))
}

.bg-indigo {
  background-color: #4835d4;
}

@media (min-width: 992px) {
  .card-registration-2 .bg-indigo {
    border-top-right-radius: 15px;
    border-bottom-right-radius: 15px;
  }
}

@media (max-width: 991px) {
  .card-registration-2 .bg-indigo {
    border-bottom-left-radius: 15px;
    border-bottom-right-radius: 15px;
  }
}
</style>
