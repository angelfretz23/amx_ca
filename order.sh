
function order() {
  curl -X POST \
  http://localhost:8080/order \
  -d "$1"
}