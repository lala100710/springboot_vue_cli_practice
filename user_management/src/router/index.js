import { createRouter, createWebHistory } from "vue-router";
import home from "@/components/indexPage.vue";
import updatePage from "@/components/updatePage.vue";
import addPage from "@/components/addUserPage.vue";
export const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: "/", component: home, name: "home" },
    { path: "/update/:id", name: "id", component: updatePage },
    { path: "/add", name: "ADD", component: addPage },
  ],
});
