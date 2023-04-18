import React from "react";
import bookTerm from "../Books/bookTerm";

const books = (props) =>{
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"row"}>
                    <table className={"table table-stripped"}>
                        <thead>
                            <tr>
                                <th scope={"col"}>Name</th>
                                <th scope={"col"}>Author</th>
                                <th scope={"col"}>Category</th>
                                {/*<th scope={"col"}>Available Copies</th>*/}
                                {/*<th scope={"col"}>Is Rented</th>*/}
                            </tr>
                        </thead>
                        <tbody>
                        {props.books.map((term) => {
                            return (
                                <bookTerm term={term} onDelete={props.onDelete}/>
                            );
                        })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );

}

export default books;