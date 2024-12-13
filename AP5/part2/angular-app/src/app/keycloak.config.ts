import { KeycloakConfig } from 'keycloak-js';

const keycloakConfig: KeycloakConfig = {
  url: 'http://localhost:8088',
  realm: 'my_realm',
  clientId: 'my_app'
};

export default keycloakConfig;
