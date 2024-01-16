import React, { useContext, useState } from 'react';

const SearchContext = createContext();

const useSearchContext = () => {
    const obj = useContext(SearchContext);
    return obj;
}

const SearchContextProvider = ({children}) => {

    const keyword = useRef();
    const [searchedVo, setSearchedVo] = useState([]);

    useEffect(()=>{
        if(keyword !== undefined) {
            
        }
    }, [])

    return (
        <SearchContext.Provider >
            {children}
        </SearchContext.Provider>
    );
};

export {useSearchContext, SearchContextProvider};