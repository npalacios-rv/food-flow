export interface LoginRequest {
    email: string;
    password?: string;
}

export interface AuthResponse {
    token: string;
    email: string;
    nombre: string;
    rol: string;
}

export interface UserSession {
    email: string;
    nombre: string;
    rol: 'ADMIN' | 'MESERO' | 'COCINA';
}