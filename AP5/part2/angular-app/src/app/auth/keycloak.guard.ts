import { inject } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';

export const KeycloakGuard = (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) => {
  const keycloakService = inject(KeycloakService);
  const router = inject(Router);

  if (!keycloakService.isLoggedIn()) {
    router.navigate(['/']);
    return false;
  }

  const requiredRoles = route.data['roles'];
  if (!requiredRoles || requiredRoles.length === 0) {
    return true;
  }

  return requiredRoles.some((role: string) => keycloakService.isUserInRole(role));
};