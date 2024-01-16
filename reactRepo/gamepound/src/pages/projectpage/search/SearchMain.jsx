import React, { useEffect } from 'react';
import styled from 'styled-components';
import Condition from '../../../component/search/Condition';
import { useSearchContext } from '../../../component/context/SearchContext';
import ProjectSearch from './ProjectSearch';
import { useParams } from 'react-router-dom';

const StyledProjectSearchDiv = styled.div`
    width: 1200px;
    margin: auto;
`;

const SearchMain = () => {
    
    const {query} = useParams();
    console.log(query);

    return (
        <StyledProjectSearchDiv>
            <Condition query={query}/>
            <ProjectSearch />
        </StyledProjectSearchDiv>
    );
};

export default SearchMain;