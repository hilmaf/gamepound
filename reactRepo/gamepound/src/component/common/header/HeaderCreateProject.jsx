import React from 'react';
import styled from 'styled-components';
import { useProjectCreateMemory } from '../../context/ProjectCreateContext';

const StyledHeaderCreateProjectDiv = styled.div`

`;

const HeaderCreateProject = () => {

    const {projectCreateData, IsProjectInputChange, dataFrom, headerFormVo, projectNo} = useProjectCreateMemory();
    
    const handleSaveData = (e) => {
        const { name } = e.target;
        if(name === 'basic'){
            const formData = new FormData();
            formData.append('title', headerFormVo.title);
            formData.append('imageUrl', headerFormVo.imageUrl);
            formData.append('mainCategoryNo', headerFormVo.mainCategoryNo);
            formData.append('subCategoryNo', headerFormVo.subCategoryNo);
            formData.append('no', projectNo.no);
            console.log(formData);
            fetch('http://localhost:8889/gamepound/project/save/basic', {
                method: 'post',
                body: formData,
            })
            .then(resp => resp.json())
            .then(data => {
                console.log(data);
            })
            ;
        }
    }

    return (
        <StyledHeaderCreateProjectDiv>
            { // createMain 버튼
                (
                    projectCreateData ?
                        IsProjectInputChange ?
                        (
                            <button className="createMainStateBtn" name={dataFrom ? dataFrom : ''} onClick={handleSaveData}>저장하기</button>
                        )
                        :
                        ( 
                            <button
                                className="createMainStateBtn"
                                disabled={!(projectCreateData.totalCompletionRate === 100)}
                            >
                            {
                                projectCreateData.totalCompletionRate === 100 ?
                                '승인요청'
                                :
                                `기획중 · ${projectCreateData.totalCompletionRate}% 완료`
                            }
                            </button>
                        )
                    :
                    ''
                )
            }
        </StyledHeaderCreateProjectDiv>
    );
};

export default HeaderCreateProject;