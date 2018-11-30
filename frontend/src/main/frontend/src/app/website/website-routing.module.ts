import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContentComponent } from './content/content.component';
import { HomeComponent } from './home/home.component';
import { ArticleComponent } from './article/article.component';
import { CategoryComponent } from './category/category.component';
import { TagComponent } from './tag/tag.component';
const routes: Routes = [
  {
    path: '',
    component: ContentComponent,
    children: [
      {
        path: '',
        component: HomeComponent
      },
      {
        path: 'article/:id',
        component: ArticleComponent
      },
      {
        path: 'category/:id',
        component: CategoryComponent
      },
      {
        path: 'category/:id/page/:page',
        component: CategoryComponent
      },
      {
        path: 'tag/:id',
        component: TagComponent
      },
      {
        path: 'tag/:id/page/:page',
        component: TagComponent
      },
      { path: 'dummy' }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WebsiteRoutingModule { }
