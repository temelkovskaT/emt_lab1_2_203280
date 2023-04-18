import React from "react";
import {Link} from "react-router-dom";

const bookTerm = (props) =>{
    return(
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.category}</td>
            <td>{props.term.author.name}</td>
            <td>{props.term.availableCopies}</td>
            <td>
                <div className={"text-right btn-group"}
                role={"group"}
                aria-label={"Basic example"}>
                    <Link
                    title={"Delete"}
                    className={"btn btn-secondary btn-danger btn-sm"}
                    onClick={()=> props.onDelete(props.term.id)}>
                        Delete
                    </Link>
                </div>
            </td>
        </tr>
    );
}


export default bookTerm;