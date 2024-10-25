
# AuthenticatedBookStore

  

## How to run

First things first, this project only makes sense with the keycloak environment runnig, so you'll need docker to run the keycloak. Once you've docker installed, run this command to download the keycloak image and start the container:
`docker run -p 8080:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:26.0.2 start-dev`

After that, open the keycloak dashboard that is running on "http://localhost:8080/admin", considering that you had execute the previous command just like it was, on the port "8080".