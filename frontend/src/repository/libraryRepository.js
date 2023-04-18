import axios from '../custom-axios/axios';

const LabService = {
    fetchBooks: () => {
        return axios.get("/books")
    },
    fetchCategories: () =>{
        return axios.get("/categories");
    },
    fetchAuthors: ()=>{
        return axios.get("/authors");
    },
    deleteBook: (id) =>{
        return axios.delete(`/books/${id}`);
    }

}

export default LabService;