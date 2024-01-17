import React from 'react';
import styled from 'styled-components';
import ProjectBoxInfo from '../../../component/project/ProjectBoxInfo';
import { useSearchContext } from '../../../component/context/SearchContext';

const StyledProjectSearchDiv = styled.div`
    width: 1200px;
    display: flex;
    flex-wrap: wrap;
`;

const ProjectSearch = () => {

    const {searchedVo, setSearchedVo} = useSearchContext();
    
    const searchedList = searchedVo.data;

    return (
        <StyledProjectSearchDiv>
            
            {searchedList!==undefined
            ?
            searchedList.map((vo)=> {
                return <ProjectBoxInfo no={4} project={vo}/>
            })
            :
            <div>
                검색 결과 없음
            </div>}
        
        </StyledProjectSearchDiv>
    );
};

export default ProjectSearch;