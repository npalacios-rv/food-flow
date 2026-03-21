import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-dashboard',
  imports: [],
  standalone: true,
  template: `
    <div class="min-h-screen bg-slate-100 flex items-center justify-center p-6">
      <div class="bg-white rounded-3xl shadow-xl p-12 text-center max-w-2xl w-full border border-slate-200">
        <h1 class="text-4xl md:text-5xl font-black text-slate-800 tracking-tight mb-4">
          Bienvenidos al <br/><span class="text-blue-600">Panel de Administración</span>
        </h1>
        <p class="text-slate-500 font-medium">Desde aquí podrás gestionar FoodFlow de manera rápida y segura.</p>
      </div>
    </div>
  `,
  styles: ``
})
export class AdminDashboardComponent {

}
