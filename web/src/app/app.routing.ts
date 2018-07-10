import { Routes, RouterModule } from '@angular/router';

import { KeyvalueComponent } from './keyvalue'; 
import { AuditComponent } from './audit'; 

const appRoutes: Routes = [
    { path: 'keyvalue', component: KeyvalueComponent },
    { path: 'audit', component: AuditComponent }, 

    // otherwise redirect to home
    { path: '**', redirectTo: 'keyvalue' }
];

export const routing = RouterModule.forRoot(appRoutes);