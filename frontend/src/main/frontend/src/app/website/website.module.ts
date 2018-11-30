import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WebsiteRoutingModule } from './website-routing.module';
import { ContentComponent } from './content/content.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { FooterComponent } from './footer/footer.component';
import { ArticleComponent } from './article/article.component';
import { TagComponent } from './tag/tag.component';
import { CategoryComponent } from './category/category.component';

@NgModule({
  declarations: [ContentComponent, HeaderComponent, HomeComponent, SidebarComponent, FooterComponent,
     ArticleComponent, TagComponent, CategoryComponent],
  imports: [
    CommonModule,
    WebsiteRoutingModule
    ],
  bootstrap: [ContentComponent]
})
export class WebsiteModule { }
