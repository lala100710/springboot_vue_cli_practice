import { createApp } from "vue";
import App from "./App.vue";
import Vue3Material from "vue3-material";
import { router } from "./router";
import axios from "axios";
import VueAxios from "vue-axios";
createApp(App).use(Vue3Material).use(router).use(VueAxios,axios).mount("#app");
import "bootstrap/dist/css/bootstrap.min.css";
import "vue3-material/dist/vue3-material.min.js";
import "bootstrap";
