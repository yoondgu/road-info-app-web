<template>
  <div class="home">
    <Tmap />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import Tmap from '@/components/Tmap.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld,
    Tmap
  }
}
</script>
