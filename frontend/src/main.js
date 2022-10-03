import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import LoadScript from "vue-plugin-load-script";
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap'

createApp(App)
    .use(router)
    .use(LoadScript)
    .mount('#app')
