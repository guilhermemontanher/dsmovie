import MovieCard from "components/MovieCard";
import MovieScore from "components/MovieScore";
import MovieStarts from "components/MovieStars";
import Pagination from "components/Pagination";

function Listing() {
    return (
        <>
            <Pagination />
            <MovieCard />
        </>
        
    );
}

export default Listing;