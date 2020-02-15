import Vue from 'vue'
import App from './App'
import router from './router'
import 'vue-material/dist/vue-material.min.css'
import 'vue-material/dist/theme/default.css'
import VueMaterial from 'vue-material';

Vue.use(VueMaterial);
Vue.config.productionTip = false;


new Vue({
  router,
  render: h => h(App)
}).$mount('#app');