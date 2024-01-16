import React, { useEffect } from 'react';
import styled from 'styled-components';
import Condition from '../../../component/search/Condition';
import { useSearchContext } from '../../../component/context/SearchContext';
import ProjectSearch from './ProjectSearch';

const StyledProjectSearchDiv = styled.div`
`;

const SearchMain = () => {
    
    const {keyword, searchedVo, setSearchedVo} = useSearchContext();

    return (
        <StyledProjectSearchDiv>
            <Condition />
            <ProjectSearch result = {searchedVo}/>
        </StyledProjectSearchDiv>
    );
};

export default SearchMain;