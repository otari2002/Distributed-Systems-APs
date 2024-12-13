import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})

export class NavbarComponent implements OnInit {
  isAdmin = false;

  constructor(private keycloakService: KeycloakService) {}

  ngOnInit() {
    this.isAdmin = this.keycloakService.isUserInRole('ADMIN');
  }

  logout() {
    this.keycloakService.logout('http://localhost:4200');
  }
}