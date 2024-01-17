import React, { createContext, useContext, useEffect, useRef, useState } from 'react';

const SearchContext = createContext();

const useSearchContext = () => {
    const obj = useContext(SearchContext);
    return obj;
}

const SearchContextProvider = ({children}) => {

    const [keyword, setKeyword] = useState();
    const [searchedVo, setSearchedVo] = useState([]);

    return (
        <SearchContext.Provider value={{keyword, setKeyword, searchedVo, setSearchedVo}}>
            {children}
        </SearchContext.Provider>
    );
};

export {useSearchContext, SearchContextProvider};