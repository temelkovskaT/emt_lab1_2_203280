import React from "react";
import categoryTerm from '../CategoryTerm/categoryTerm';

const categories = (props) => {
    return(
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"row"}>
                    <table className={"table table-stripped"}>
                        <thead>
                            <tr>
                                <th scope={"col"}>Category</th>
                            </tr>
                        </thead>
                        <tbody>
                        {props.categories.map((term) =>{
                            return <categoryTerm term={term}></categoryTerm>
                        })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}


export default categories;
