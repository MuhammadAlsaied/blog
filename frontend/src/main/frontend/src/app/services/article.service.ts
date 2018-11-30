import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class ArticleService {
    url = 'http://localhost:8080/api/';
    constructor(private http: HttpClient) { }
    result;
    getArticles() {
        return this.http.get(this.url + 'articles').pipe(
            map(response => response));
    }
    getArticlesByCategory(id, page) {
        return this.http.get(this.url + 'categories/' + id + '/articles/page/' + page).pipe(
            map(response => response));
    } getArticlesByTag(id, page) {
        return this.http.get(this.url + 'tags/' + id + '/articles/page/' + page).pipe(
            map(response => response));
    }
    getPopularArticles() {
        return this.http.get(this.url + 'articles/popular').pipe(
            map(response => response));
    }

    getArticle(id: number) {
        return this.http.get(this.url + 'articles/' + id).pipe(
            map(response => response));
    }
    incrementArticleviews(id: number) {
        this.http.get(this.url + 'articles/' + id + '/increment').subscribe();
    }
    getTags() {
        return this.http.get(this.url + 'tags').pipe(
            map(response => response));
    }
    getTag(id) {
        return this.http.get(this.url + 'tags/' + id).pipe(
            map(response => response));
    }

    getTagCount(id: number) {
        return this.http.get(this.url + 'tags' + '/' + id + '/' + 'count').pipe(
            map(response => response));
    }
    getCategories() {
        return this.http.get(this.url + 'categories').pipe(
            map(response => response));
    }
    getCategory(id) {
        return this.http.get(this.url + 'categories/' + id).pipe(
            map(response => response));
    }
}
