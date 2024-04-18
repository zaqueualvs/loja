import { Component } from '@angular/core';
import {MatCard, MatCardContent, MatCardFooter, MatCardHeader} from "@angular/material/card";
import {MatToolbar} from "@angular/material/toolbar";
import {MatChip, MatChipSet} from "@angular/material/chips";
import {MatIcon} from "@angular/material/icon";
import {MatProgressBar} from "@angular/material/progress-bar";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    MatCard,
    MatCardHeader,
    MatToolbar,
    MatChip,
    MatChipSet,
    MatIcon,
    MatCardContent,
    MatCardFooter,
    MatProgressBar
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}
