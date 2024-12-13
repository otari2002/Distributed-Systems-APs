import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { KeycloakService } from 'keycloak-angular';
import { Observable, from, lastValueFrom } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private keycloak: KeycloakService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return from(this.handleRequest(req, next));
  }

  private async handleRequest(req: HttpRequest<any>, next: HttpHandler) {
    try {
      const token = await this.keycloak.getToken();
      const clonedReq = req.clone({
        setHeaders: {
          'Authorization': `Bearer ${token}`,
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        }
      });
      return lastValueFrom(next.handle(clonedReq));
    } catch (error) {
      console.error('Error getting token:', error);
      return lastValueFrom(next.handle(req));
    }
  }
}
