# Keycloak Configuration and Testing

This guide provides step-by-step instructions for setting up and configuring Keycloak, as well as testing its functionalities using Postman.

## Prerequisites
- Keycloak installed on your system.
- Postman for testing authentication.
- Basic understanding of authentication concepts.

---

## Steps

### 1. Start Keycloak
- Launch your Keycloak instance. This can be done via:
  - Running the Keycloak server directly.
  - Using Docker: 
    ```bash
    docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:latest start-dev
    ```
    
### 2. Create an Admin Account
- Access Keycloak via your browser at `http://localhost:8080`.
- Follow the on-screen prompts to create an admin account.

### 3. Create a Realm
- Navigate to the **Admin Console**.
- In the left menu, select **Add Realm**.
- Enter a name for the Realm and save.
![Capture d’écran 2024-11-22 122022](https://github.com/user-attachments/assets/ad584340-c88f-4684-8a3f-11ae9ca876ee)



### 4. Create a Client to Secure
- In your Realm, go to **Clients** > **Create**.
- Enter the Client ID (e.g., `my-client`).
- Choose a protocol (e.g., `openid-connect`) and save.
- Configure client settings as needed.
![Capture d’écran 2024-11-22 122108](https://github.com/user-attachments/assets/6b12c335-424a-4590-b525-b6d9427037fb)
![Capture d’écran 2024-11-22 122154](https://github.com/user-attachments/assets/e617c076-9760-42b8-be58-0f39cfeec46d)


### 5. Create Users
- Navigate to **Users** > **Add User**.
- Fill in the details for the user and save.
![Capture d’écran 2024-11-22 122304](https://github.com/user-attachments/assets/7cb5bc56-6a0b-4614-acb5-8a47a47721f6)
![Capture d’écran 2024-11-22 122339](https://github.com/user-attachments/assets/1ffd6d0d-f305-457c-9ec1-38cf183bebd0)
- Set a password for the user under the **Credentials** tab.
![Capture d’écran 2024-11-22 122638](https://github.com/user-attachments/assets/cd82a7eb-af6a-467d-a247-e17d5611edd5)
![Capture d’écran 2024-11-22 122608](https://github.com/user-attachments/assets/bfa23b99-4ac0-47ea-a5b5-49afa5cdd769)


### 6. Create Roles
- Go to **Roles** > **Add Role**.
- Define a new role (e.g., `user` or `admin`) and save.
![Capture d’écran 2024-11-22 122424](https://github.com/user-attachments/assets/682da085-3243-40e4-be9f-2e70a396181e)


### 7. Assign Roles to Users
- In the **Users** section, select a user.
- Navigate to the **Role Mappings** tab.
- Assign the appropriate roles to the users.
![Capture d’écran 2024-11-22 122506](https://github.com/user-attachments/assets/e8f3c4ec-aada-4404-80f0-bedfc9d2368f)
![Capture d’écran 2024-11-22 122525](https://github.com/user-attachments/assets/0499547f-c5c3-4d89-8470-95348ca3c235)


### 8. Test Authentication with Postman
#### a. Authenticate with Username and Password
1. Open Postman and create a new POST request to: <br/>`http://localhost:8080/realms/{realm-name}/protocol/openid-connect/token`
2. In the body (form-data or x-www-form-urlencoded):
- `grant_type`: `password`
- `client_id`: `<your-client-id>`
- `username`: `<user-username>`
- `password`: `<user-password>`
![Capture d’écran 2024-11-22 123132](https://github.com/user-attachments/assets/5bc295e5-191c-4f68-aaa3-1cb8eb535322)


#### b. Analyze JWT Tokens
- Decode the received Access Token and Refresh Token at [jwt.io](https://jwt.io).<br/>
  -- Access Token : <br/>
![Capture d’écran 2024-11-22 123255](https://github.com/user-attachments/assets/16c58b92-785a-4fdd-9726-fa6bf14d0a67)<br/>
  -- Refresh Token :<br/>
![Capture d’écran 2024-11-22 123335](https://github.com/user-attachments/assets/6b6a2d94-d979-4abc-aebb-8078c98fb4da)<br/>


#### c. Authenticate with Refresh Token
1. Use the Refresh Token from the previous step.
2. Send a POST request to the same token endpoint with:
- `grant_type`: `refresh_token`
- `client_id`: `<your-client-id>`
- `refresh_token`: `<your-refresh-token>`
![Capture d’écran 2024-11-22 123457](https://github.com/user-attachments/assets/9013f5ea-a5eb-4e49-8fa5-004a70276cae)
