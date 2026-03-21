import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { AuthResponse, LoginRequest } from '../../models/auth.model';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly AUTH_URL = `${environment.apiUrl}/auth/usuarios`;
  constructor(private http: HttpClient) { }

  login(request: LoginRequest): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(`${this.AUTH_URL}/login`, request).pipe(
      tap(response => this.setSession(response))
    );
  }

  private setSession(authResult: AuthResponse): void {
    localStorage.setItem('token', authResult.token);
    localStorage.setItem('user_data', JSON.stringify(authResult));
  }

  logout(): void {
    localStorage.removeItem('token');
    localStorage.removeItem('user_data');
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }


  getToken(): string | null {
    return localStorage.getItem('token');
  }

  getUserRole(): string | null {
    const userData = localStorage.getItem('user_data');
    return userData ? JSON.parse(userData).rol : null;
  }
}

