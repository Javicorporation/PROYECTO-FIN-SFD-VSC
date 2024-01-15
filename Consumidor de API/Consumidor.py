import requests

url = "http://localhost:8081/Cliente/Producto/1"
response = requests.get(url) 

if response.status_code == 200:
    data = response.json()
    print(data)
else:
    print(response.status_code,"Registro inexistente" )
