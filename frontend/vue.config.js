module.exports = {
  transpileDependencies: true,
  outputDir: "../src/main/resources/static",
  devServer: {
    proxy: {
      '/api/*': {
        target: 'http://localhost',
        changeOrigin: true
      }
    }
  }
}