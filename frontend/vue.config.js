module.exports = {
  lintOnSave: false,
  transpileDependencies: true,
  outputDir: "../src/main/resources/static",
  devServer: {
    proxy: {
      '/api/road': {
        target: 'http://localhost',
        changeOrigin: true
      }
    }
  }
}