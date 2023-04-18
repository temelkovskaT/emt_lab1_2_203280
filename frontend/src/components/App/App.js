import './App.css';
import LabService from "../../repository/libraryRepository";
import React, {Component} from "react";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Books from '../Books/books'
import categories from "../Categories/CategoryList/categories";
import header from "../Header/header";

class App extends Component{

    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: [],
            authors : [],
            availableCopies: []
        }
    }

    render(){
        return(
            <Router>
                <header/>
                <main>
                    <div className="container">
                        <Routes>
                            <Route path={"/books"} exact render={() => <Books books={this.state.books} onDelete={this.deleteBook}/>}/>
                            <Route path={"/categories"} exact render={() => <categories categories={this.state.categories}/>}/>
                        </Routes>
                    </div>
                </main>
            </Router>
        );
    }
    componentDidMount(){
        this.loadBooks();
        this.loadCategories();
        this.loadAuthors();
    }

    loadBooks = () => {
        LabService.fetchBooks()
            .then((data) =>{
                this.setState({
                    books: data.data
                });
            });
    }

    loadCategories = () =>{
        LabService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                });
            })
    }

    loadAuthors = () => {
        LabService.fetchAuthors()
            .then((data)  =>{
                this.setState({
                    authors: data.data
                })
            })
    }

    deleteBook = (id) => {
        LabService.deleteBook(id)
            .then(() =>{
                this.loadBooks();
            })
    }


}

export default App;
