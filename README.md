
## Before Beginning
To make orders via terminal, there is a script called `order.sh` in the project root that makes a `cURL` request to 
`localhost:8080/orders`. You will need to source this file in your terminal by running:
```
$ source order.sh
```

Now you can make orders (Note: Order Service needs to be Running):
```
// Single item
$ order apple

// Multiple items
$ order 'apple orange apple, orange'
```