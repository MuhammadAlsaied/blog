import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../../services/article.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  popularArticles;
  tags;
  counts = new Map();
  constructor(private articleService: ArticleService) { }

  ngOnInit() {
    this.articleService.getTags().subscribe(res => this.handleTags(res));
    this.articleService.getPopularArticles().subscribe(res => this.popularArticles = res);
  }

  handleTags(tags) {
    this.tags = tags;
    for (const t of tags) {
      this.articleService.getTagCount(t.id).subscribe(res => this.counts.set(t.id, res));
    }
  }

}
